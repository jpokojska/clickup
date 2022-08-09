package com.clickup.tests.e2e;


import com.clickup.properties.ClickupProperties;
import com.clickup.requests.list.CreateListRequest;
import com.clickup.requests.list.DeleteListRequest;
import com.clickup.requests.space.CreateSpaceRequest;
import com.clickup.requests.space.DeleteSpaceRequest;
import com.clickup.requests.space.GetSpacesRequest;
import com.clickup.requests.space.UpdateSpaceRequest;
import com.clickup.requests.task.CreateTaskRequest;
import com.clickup.requests.task.DeleteTaskRequest;
import com.clickup.requests.task.GetTasksRequest;
import com.clickup.requests.task.UpdateTaskRequest;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class E2ETest {


    private static final Logger LOGGER = LoggerFactory.getLogger(E2ETest.class);
    private static String spaceName = "Space e2e";
    private static String listName = "list test";
    private static String taskName = "task test";
    private static String updatedTaskName = "task updated";
    private static String updatedSpaceName = "space updated";
    private static String spaceId;
    private static String listId;
    private static String taskId;

    @Test
    void e2eTest() {
        spaceId = createSpace();
        LOGGER.info("Space created with id: {}", spaceId);
        listId = createList();
        LOGGER.info("List created with id: {}", listId);
        taskId = createTask();
        LOGGER.info("List created with id: {}", taskId);
        getTasks();
        updateTask();
        updateSpace();
        getSpaces();
        deleteTask();
        deleteList();
        deleteSpace();
    }

    private String createSpace() {
        JSONObject json = new JSONObject();
        json.put("name", spaceName);


        final var response = CreateSpaceRequest.createSpace(json);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(spaceName);

        return jsonData.getString("id");
    }

    private String createList() {

        JSONObject json = new JSONObject();
        json.put("name", listName);


        final var response = CreateListRequest.createList(json, spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(listName);

        return jsonData.getString("id");

    }

    private String createTask() {
        JSONObject json = new JSONObject();
        json.put("name", taskName);


        final var response = CreateTaskRequest.createTask(json, listId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(taskName);

        return jsonData.getString("id");
    }

    private void getTasks() {

        final var response = GetTasksRequest.getTasks(listId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

    }

    private void updateTask() {
        JSONObject json = new JSONObject();
        json.put("name", updatedTaskName);


        final var response = UpdateTaskRequest.updateTask(json, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(updatedTaskName);


    }

    private void updateSpace() {
        JSONObject json = new JSONObject();
        json.put("name", updatedSpaceName);


        final var response = UpdateSpaceRequest.updateSpace(json, spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(updatedSpaceName);


    }

    private void getSpaces() {

        final var response = GetSpacesRequest.getSpaces(ClickupProperties.getTeamId());
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

    }

    private void deleteTask() {

        final var response = DeleteTaskRequest.deleteTask(taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(204);

    }

    private void deleteList() {

        final var response = DeleteListRequest.deleteList(listId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

    }

    private void deleteSpace() {

        final var response = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

    }
}

