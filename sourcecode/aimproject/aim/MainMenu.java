package aimproject.aim;

public class MainMenu {
    private String title;
    private SortAlgorithm selectedAlgorithm;

    public MainMenu(String title) {
        this.title = title;
    }

    public void displayMenu() {
        System.out.println("=== " + title + " ===");
        System.out.println("1. Chọn thuật toán sắp xếp");
        System.out.println("2. Hiển thị hướng dẫn");
        System.out.println("3. Thoát");
    }

    public SortAlgorithm selectAlgorithm(int choice) {
        switch (choice) {
            case 1:
                selectedAlgorithm = new SelectionSort();
                System.out.println("Thuật toán SelectionSort được chọn.");
                break;
            case 2:
                selectedAlgorithm = new MergeSort();
                System.out.println("Thuật toán MergeSort được chọn.");
                break;
            case 3:
                selectedAlgorithm = new ShellSort();
                System.out.println("Thuật toán ShellSort được chọn.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
        return selectedAlgorithm;
    }

    public void showHelp() {
        System.out.println("Hướng dẫn: Chọn một thuật toán và nhập các tham số để xem cách nó hoạt động.");
    }

    public void quit() {
        System.out.println("Thoát chương trình. Tạm biệt!");
    }
}
