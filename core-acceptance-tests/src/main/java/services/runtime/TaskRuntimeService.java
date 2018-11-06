package services.runtime;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.activiti.api.task.model.payloads.CreateTaskPayload;
import org.activiti.cloud.api.task.model.CloudTask;
import org.activiti.cloud.qa.service.BaseService;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resources;

public interface TaskRuntimeService extends BaseService {

    String TASKS_PATH = "/v1/tasks/";

    @RequestLine("GET /v1/process-instances/{id}/tasks")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/hal+json;charset=UTF-8"
    })
    PagedResources<CloudTask> getProcessInstanceTasks(@Param("id") String id);

    @RequestLine("POST /v1/tasks/{id}/claim")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    void assignTaskToUser(@Param("id") String id,
                          @Param("assignee") String user);

    @RequestLine("POST /v1/tasks/{id}/complete")
    @Headers("Content-Type: application/json")
    void completeTask(@Param("id") String id);

    @RequestLine("POST /v1/tasks/")
    @Headers("Content-Type: application/json")
    CloudTask createNewTask(CreateTaskPayload task);

    @RequestLine("GET /v1/tasks/{id}")
    CloudTask getTaskById(@Param("id") String id);

    @RequestLine("DELETE /v1/tasks/{id}")
    void deleteTask(@Param("id") String id);

    @RequestLine("POST /v1/tasks/{parentTaskId}/subtask")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/hal+json;charset=UTF-8"
    })
    CloudTask createSubtask(@Param("parentTaskId") String parentTaskId,
                            CreateTaskPayload createTaskCmd);

    @RequestLine("GET /v1/tasks/{parentTaskId}/subtasks")
    Resources<CloudTask> getSubtasks(@Param("parentTaskId") String parentTaskId);

    @RequestLine("GET /v1/tasks")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/hal+json;charset=UTF-8"
    })
    PagedResources<CloudTask> getAllTasks();
}
