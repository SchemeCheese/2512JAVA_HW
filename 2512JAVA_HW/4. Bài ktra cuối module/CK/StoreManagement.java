package CK;

import java.util.Scanner;

public class StoreManagement {
    private final int MAX_CATEGORIES = 5;
    private final int MAX_PRODUCTS_PER_CAT = 20;

    private Product[][] storage = new Product[MAX_CATEGORIES][MAX_PRODUCTS_PER_CAT];
    private int[] counts = new int[MAX_CATEGORIES];
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        int n = 0;
        System.out.print("Bạn muốn thêm bao nhiêu sản phẩm? ");
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên!");
            return;
        }

        if (n <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập sản phẩm thứ " + (i + 1) + "/" + n + "");
            System.out.println("Danh mục:\n0. Điện tử\n1. Gia dụng\n2. Thực phẩm\n3. Thời trang\n4. Khác");
            System.out.print("Chọn mã danh mục (0-4): ");

            int catId;
            try {
                catId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Danh mục phải là số! Mời nhập lại sản phẩm này.");
                i--; continue;
            }

            if (catId < 0 || catId >= MAX_CATEGORIES) {
                System.out.println("Lỗi: Danh mục không tồn tại! Mời nhập lại.");
                i--; continue;
            }

            if (counts[catId] >= MAX_PRODUCTS_PER_CAT) {
                System.out.println("-> Lỗi: Danh mục này đã đầy (Max 20)! Mời chọn danh mục khác.");
                i--; continue;
            }

            System.out.print("Nhập ID: ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: ID bắt buộc phải là số! Mời nhập lại.");
                i--; continue;
            }

            System.out.print("Nhập tên sản phẩm: ");
            String rawName = scanner.nextLine();
            String name = Product.formatName(rawName);

            Product tempProd = new Product(id, name, 0, 0);
            boolean isDuplicate = false;
            for (int k = 0; k < counts[catId]; k++) {
                if (storage[catId][k].equals(tempProd)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Lỗi: Sản phẩm đã tồn tại (trùng ID hoặc Tên)! Mời nhập lại.");
                i--; continue;
            }

            double price;
            int quantity;
            try {
                System.out.print("Nhập giá: ");
                price = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập số lượng: ");
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá hoặc số lượng phải là số! Mời nhập lại.");
                i--; continue;
            }

            storage[catId][counts[catId]] = new Product(id, name, price, quantity);
            counts[catId]++;

            System.out.println("Đã thêm thành công: " + name);
        }
        System.out.println("\nHOÀN TẤT NHẬP " + n + " SẢN PHẨM");
    }

    public void searchByName() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("Kết quả tìm kiếm:");
        for (int i = 0; i < MAX_CATEGORIES; i++) {
            for (int j = 0; j < counts[i]; j++) {
                if (storage[i][j].getName().toLowerCase().contains(keyword)) {
                    System.out.println(storage[i][j].toString());
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm phù hợp.");
    }

    public void deleteById() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID phải là số!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < MAX_CATEGORIES; i++) {
            for (int j = 0; j < counts[i]; j++) {
                if (storage[i][j].getId() == id) {
                    for (int k = j; k < counts[i] - 1; k++) {
                        storage[i][k] = storage[i][k + 1];
                    }
                    storage[i][counts[i] - 1] = null;
                    counts[i]--;
                    System.out.println("Đã xóa sản phẩm ID " + id + " khỏi danh mục " + i);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm cần xóa.");
    }

    public void sortAndDisplay() {
        int totalProducts = 0;
        for (int c : counts) totalProducts += c;

        if (totalProducts == 0) {
            System.out.println("Kho trống.");
            return;
        }

        Product[] flatList = new Product[totalProducts];
        int index = 0;
        for (int i = 0; i < MAX_CATEGORIES; i++) {
            for (int j = 0; j < counts[i]; j++) {
                flatList[index++] = storage[i][j];
            }
        }

        mergeSort(flatList, 0, totalProducts - 1);

        System.out.println("Danh sách sau khi sắp xếp:");
        for (Product p : flatList) {
            System.out.println(p.toString());
        }
    }

    private void mergeSort(Product[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(Product[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Product[] L = new Product[n1];
        Product[] R = new Product[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].getPrice() >= R[j].getPrice()) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public void showStatistics() {
        System.out.println("\nTHỐNG KÊ CHI TIẾT KHO HÀNG");

        String[] catNames = {"Điện tử", "Gia dụng", "Thực phẩm", "Thời trang", "Khác"};

        double maxTotal = -1;
        int bestCategory = -1;
        boolean isEmptyStore = true;

        for (int i = 0; i < MAX_CATEGORIES; i++) {
            if (counts[i] > 0) {
                isEmptyStore = false;
                double categoryTotal = 0;

                System.out.println("DANH MỤC " + i + ": " + catNames[i].toUpperCase());

                System.out.printf("%-5s | %-15s | %-12s | %-5s | %-12s\n", "ID", "Tên SP", "Giá", "SL", "Thành tiền");
                for (int j = 0; j < counts[i]; j++) {
                    Product p = storage[i][j];
                    double lineTotal = p.getPrice() * p.getQuantity();
                    categoryTotal += lineTotal;

                    System.out.printf("%-5d | %-15s | %, -12.0f | %-5d | %, -12.0f\n",
                            p.getId(),
                            p.getName(),
                            p.getPrice(),
                            p.getQuantity(),
                            lineTotal);
                }

                System.out.println("Tổng cộng danh mục " + i + ": " + String.format("%,.0f", categoryTotal));

                if (categoryTotal > maxTotal) {
                    maxTotal = categoryTotal;
                    bestCategory = i;
                }
            }
        }

        if (isEmptyStore) {
            System.out.println("Kho hàng hiện tại đang trống.");
        } else {
            System.out.println("DANH MỤC CÓ GIÁ TRỊ LỚN NHẤT: " + bestCategory + " (" + catNames[bestCategory] + ")");
            System.out.println("Tổng giá trị: " + String.format("%,.0f", maxTotal));
        }
    }
}