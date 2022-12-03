package com.berkanaslan.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookControllerTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("size()", is(5));
    }

    @Test
    public void shouldCountAllBoks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/books/count")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("5"));
    }

    @Test
    public void shouldGetBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", "4")
                .when().get("/api/books/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("title", is("Thinking in Java"));
    }
}