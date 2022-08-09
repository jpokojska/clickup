package com.clickup.tests.space;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class GetSpacesTest {

    @Test
    void getSpacesTest() {

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .when()
                .get(ClickupUrl.getSpacesUrl(ClickupProperties.getTeamId()))
                .then()
                .log().all()
                .extract()
                .response();
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
}
