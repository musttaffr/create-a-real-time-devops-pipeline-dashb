import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Data model for real-time DevOps pipeline dashboard

public class DevOpsPipelineDashboard {
    private String environment; // dev, staging, prod
    private List<Pipeline> pipelines; // list of pipeline objects

    public DevOpsPipelineDashboard(String environment, List<Pipeline> pipelines) {
        this.environment = environment;
        this.pipelines = pipelines;
    }

    public static class Pipeline {
        private String name; // pipeline name
        private String status; // success, fail, running
        private Stage[] stages; // array of stage objects

        public Pipeline(String name, String status, Stage[] stages) {
            this.name = name;
            this.status = status;
            this.stages = stages;
        }
    }

    public static class Stage {
        private String name; // stage name
        private String status; // success, fail, running
        private Task[] tasks; // array of task objects

        public Stage(String name, String status, Task[] tasks) {
            this.name = name;
            this.status = status;
            this.tasks = tasks;
        }
    }

    public static class Task {
        private String name; // task name
        private String status; // success, fail, running
        private long startTime; // task start time in millis
        private long endTime; // task end time in millis

        public Task(String name, String status, long startTime, long endTime) {
            this.name = name;
            this.status = status;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    // Example usage:
    public static void main(String[] args) {
        Task task1 = new Task("Build", "success", 1643723400, 1643723410);
        Task task2 = new Task("Deploy", "running", 1643723410, 0);
        Stage stage = new Stage("CI/CD", "running", new Task[]{task1, task2});
        Pipeline pipeline = new Pipeline("MyPipeline", "running", new Stage[]{stage});

        DevOpsPipelineDashboard dashboard = new DevOpsPipelineDashboard("dev", Arrays.asList(pipeline));
    }
}