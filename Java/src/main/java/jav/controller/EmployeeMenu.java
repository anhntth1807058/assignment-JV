package jav.controller;

import jav.entity.Employee;
import jav.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeMenu {
    private Scanner scanner = new Scanner(System.in);
    private Employee employee = new Employee();
    private EmployeeModel model = new EmployeeModel();


    public void create() {
        while (true) {
            System.out.println("-------------Menu------------");
            System.out.println("1. Đăng ký tài khoản ");
            System.out.println("2. Đăng nhập tài khoản");
            System.out.println("3. Thoát chương trình");
            System.out.println("-----------------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Đăng ký tài khoản.");
                    System.out.println("Vui lòng điền thông tin sau: ");
                    while (true) {
                        System.out.println("Tên: ");
                        String name = scanner.nextLine();
                        System.out.println("Địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.println("Email: ");
                        String email = scanner.nextLine();
                        System.out.println("Tài khoản: ");
                        String account = scanner.nextLine();
                        System.out.println("Mật khẩu: ");
                        String password = scanner.nextLine();
                        System.out.println("Ngày tạo: ");
                        String createdAt = scanner.nextLine();
                        System.out.println("Ngày update: ");
                        String updatedAt = scanner.nextLine();
                        System.out.println("Nhập trạng thái: ");
                        int status = scanner.nextInt();
                        Employee employee = new Employee(name, address, email, account, password, createdAt, updatedAt, status);
                        if(!model.checkExistAccount(account)) {
                            model.register(employee);
                            break;
                        }
                        System.out.println("Vui lòng nhập lại các thông tin: ");
                    }
                    break;
                case 2:
                    System.out.println("Đăng nhập tài khoản.");
                    System.out.println("Vui lòng nhập tài khoản và mật khẩu: ");
                    System.out.println("Tài khoản: ");
                    String account = scanner.nextLine();
                    System.out.println("Mật khẩu: ");
                    String password = scanner.nextLine();
                    Employee emp = model.login(account, password);
                    if (emp == null) {
                        System.out.println("Sai thông tin tài khoản.");
                    } else {
                        System.out.println("Đăng nhập thành công.");
                        System.out.println("Thông tin: ");
                        System.out.printf("%20s | %20s | %20s | %20s | %20s | %20s | %20s | %20s |\n", "Tên", "Địa chỉ", "Email", "Tài khoản", "Mật khẩu", "Ngày tạo", "Ngày update", "Status");
                        System.out.printf("%20s | %20s | %20s | %20s | %20s | %20s | %20s | %20s |\n", employee.getName(), employee.getAddress(), employee.getEmail(), employee.getAccount(), employee.getPassword(), employee.getCreatedAt(), employee.getUpdatedAt(), employee.getStatus());
                    }
                    break;
                case 3:
                    System.out.println("Thoát . Hẹn gặp lại.");
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập lại trong khoảng từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }
}
