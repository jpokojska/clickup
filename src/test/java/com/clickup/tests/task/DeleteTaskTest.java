package com.clickup.tests.task;

import com.clickup.properties.ClickupProperties;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTaskTest {

    @Test
    void deleteTaskTest(){

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.clickup.com/api/v2/task/2q374zw")
                .then()
                .log().all()
                .extract()
                .response();
        Assertions.assertThat(response.statusCode()).isEqualTo(204);
    }
}
