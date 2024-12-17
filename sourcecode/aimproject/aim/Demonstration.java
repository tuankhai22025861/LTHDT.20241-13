package aimproject.aim;
import java.util.Scanner;
public class Demonstration {
    private SortAlgorithm currentAlgorithm;
    private int[] array;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayManager arrayManager = new ArrayManager();
        MainMenu menu = new MainMenu("Chương trình Mô phỏng Thuật toán Sắp xếp");
        boolean running = true;
        while (running) {
            menu.displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chọn thuật toán: ");
                    System.out.println("1. SelectionSort");
                    System.out.println("2. MergeSort");
                    System.out.println("3. ShellSort");
                    int algorithmChoice = scanner.nextInt();
                    currentAlgorithm = menu.selectAlgorithm(algorithmChoice);
                    // Cho phép người dùng chọn cách tạo mảng
                    System.out.println("Chọn cách tạo mảng:");
                    System.out.println("1. Nhập mảng thủ công");
                    System.out.println("2. Tạo mảng ngẫu nhiên");
                    int arrayChoice = scanner.nextInt();
                    if (arrayChoice == 1) {
                        array = arrayManager.inputArray();
                    } else if (arrayChoice == 2) {
                        System.out.print("Nhập kích thước mảng: ");
                        int size = scanner.nextInt();
                        array = arrayManager.createRandomArray(size);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                        continue;
                    }
                    currentAlgorithm.setArray(array);
                    currentAlgorithm.sort();
                    System.out.println("Sắp xếp xong!");
                    break;
                case 2:
                    menu.showHelp();
                    break;
                case 3:
                    // Thêm xác nhận trước khi thoát
                    System.out.print("Bạn có chắc chắn muốn thoát chương trình? (1: Có, 2: Không): ");
                    int exitChoice = scanner.nextInt();
                    if (exitChoice == 1) {
                        menu.quit();
                        running = false;
                    } else {
                        System.out.println("Tiếp tục chương trình...");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
        scanner.close();
    }
    public void returnToMenu() {
        System.out.println("Quay lại menu chính...");
    }
    public void setAlgorithm(SortAlgorithm algorithm) {
        this.currentAlgorithm = algorithm;
    }
}