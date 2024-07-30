public class Task_Management_System {

    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    public static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public static class TaskList {
        private Node head;

        public TaskList() {
            this.head = null;
        }

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public boolean deleteTask(int taskId) {
            if (head == null) {
                return false;
            }

            if (head.task.getTaskId() == taskId) {
                head = head.next;
                return true;
            }

            Node current = head;
            while (current.next != null && current.next.task.getTaskId() != taskId) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                return true;
            }

            return false;
        }

        public void traverseTasks() {
            Node current = head;
            if (current == null) {
                System.out.println("No tasks available.");
                return;
            }

            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Traverse Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String addStatus = scanner.nextLine();
                    Task newTask = new Task(addId, addName, addStatus);
                    taskList.addTask(newTask);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = taskList.searchTask(searchId);
                    System.out.println("Search Result: " + (foundTask != null ? foundTask : "Task not found"));
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleted = taskList.deleteTask(deleteId);
                    if (deleted) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4:
                    System.out.println("Current Tasks:");
                    taskList.traverseTasks();
                    break;

                case 5:
                    continueManaging = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
