package com.clickup.tests.space;

import com.clickup.properties.ClickupProperties;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class DeleteSpaceTest {

    @Test
    void deleteSpaceTest() {

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.clickup.com/api/v2/space/60709034")
                .then()
                .log().all()
                .extract()
                .response();
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
}
