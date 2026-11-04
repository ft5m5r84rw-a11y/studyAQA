package booking;

import booking.dto.AuthRequest;
import booking.dto.AuthResponse;
import booking.dto.CreateBookingDTO;
import booking.dto.CreateBookingDTO.BookingDates;
import booking.dto.CreateBookingResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingTest {

    private static final String BOOKING_URL =
            "https://restful-booker.herokuapp.com";

    @BeforeAll
    static void setUP() {
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
    }

    @Test
    void authTest() {
        String user = "admin";
        String password = "password123";

        AuthResponse resp = given()
                .contentType(ContentType.JSON)
                .body(new AuthRequest(user, password))
                .when()
                .post(BOOKING_URL + "/auth")
                .then()
                .statusCode(200)
                .extract().as(AuthResponse.class);

        assertThat(resp.getToken()).isNotNull();
    }

    @Test
    void createBookingTest() {
        CreateBookingDTO booking = bookingRequest();

        CreateBookingResponse response = given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(200)
                .extract().as(CreateBookingResponse.class);

        assertThat(response.getBookingid()).isNotNull();
        assertThat(response.getBooking().getTotalprice()).isEqualTo(1000);
        assertThat(response.getBooking().getBookingdates().getCheckin()).isEqualTo("2026-01-01");
        assertThat(response.getBooking().getDepositpaid()).isFalse();
    }


    private static CreateBookingDTO bookingRequest() {
        CreateBookingDTO booking = new CreateBookingDTO();
        booking.setFirstname("Barack");
        booking.setLastname("Obama");
        booking.setTotalprice(1000);
        booking.setDepositpaid(false);
        booking.setBookingdates(
                new BookingDates("2026-01-01", "2027-01-01")
        );
        booking.setAdditionalneeds("newspaper");

        return booking;
    }

    private static CreateBookingDTO buildBookingRequest() {
        return CreateBookingDTO.builder()
                .firstname("Barack")
                .lastname("Obama")
                .totalprice(1000)
                .depositpaid(false)
                .bookingdates(BookingDates.builder()
                        .checkin("2026-01-01")
                        .checkout("2027-01-01")
                        .build())
                .additionalneeds("newspaper")
                .build();
    }

    static Stream<Arguments> invalidCredentials() {
        return Stream.of(
                Arguments.of(new AuthRequest("admin", "password000"), 200),   //Неверный пароль
                Arguments.of(new AuthRequest("adminnn", "password123"), 200),   //Неверный логин
                Arguments.of(new AuthRequest("admin", ""), 200),   //Пустой пароль
                Arguments.of(new AuthRequest("", "password123"), 200),   //Пустой логин
                Arguments.of(new AuthRequest(), 200),   //Пустое body ({})
                Arguments.of(null, 200)   //Без body вообще

        );
    }

    @ParameterizedTest
    @MethodSource("invalidCredentials")
    void negativeAuthTest(Object body, int statusCode) {
        RequestSpecification request = given()
                .contentType(ContentType.JSON);
        if (body != null) {
            request.body(body);
        }
        Response response = request.when()
                .post(BOOKING_URL + "/auth")
                .then()
                .extract().response();

        assertThat(response.jsonPath().getString("token")).isNull();
        assertThat(response.statusCode()).isEqualTo(statusCode);

    }


    static Stream<Arguments> invalidBooking() {
        CreateBookingDTO validBooking = buildBookingRequest();

        return Stream.of(
                Arguments.of(validBooking.toBuilder().firstname(null).build(), 500),   //Без обязательного поля firstname
                Arguments.of(validBooking.toBuilder().lastname(null).build(), 500),   //Без обязательного поля lastname
                Arguments.of(validBooking.toBuilder().totalprice(-500).build(), 200),   //Отрицательная цена (totalprice: -500)
                Arguments.of(validBooking.toBuilder().bookingdates(BookingDates.builder().checkin("не-дата").checkout("2027-01-01").build()).build(), 200),   //Даты в неверном формате (checkin: "не-дата")
                Arguments.of(validBooking.toBuilder().bookingdates(BookingDates.builder().checkin("2027-01-10").checkout("2027-01-01").build()).build(), 200),   //Дата выезда раньше даты заезда
                Arguments.of(new CreateBookingDTO(), 500)    //Пустое body

        );
    }

    @ParameterizedTest
    @MethodSource("invalidBooking")
    void negativeBookingTest(CreateBookingDTO booking, int statusCode) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post(BOOKING_URL + "/booking")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(statusCode);
    }
}