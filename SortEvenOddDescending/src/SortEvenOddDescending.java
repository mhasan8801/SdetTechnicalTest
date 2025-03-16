import java.util.*;

public class SortEvenOddDescending {

    public static int[] sortEvenOddDescending(int[] nums) {

        //Urutkan genap dulu kemudian ganjil (bilangan terbesar ke terkecil)
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        //Pisahkan genap dan ganjil
        for (int num : nums) {
            if (num % 2 == 0) {
                evens.add(num); //jika genap -> list events
            } else {
                odds.add(num);//jika ganji -> list odds
            }
        }

        evens.sort(Collections.reverseOrder()); //Urutkan genap terbesar ke terkecil
        odds.sort(Collections.reverseOrder()); //Urutkan ganjil terbesar ke terkecil

        //Gabungkan angka, genap kemudian ganjil
        evens.addAll(odds);

        //Konversi list ke array
        return evens.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Inputan user jumlah bilangan
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n]; //Simpan input dari user

        //Inputan bilangan user
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt(); //Simpan input ke array
        }

        //Proses input dengan fungsi yang sudah dibuat
        int[] result = sortEvenOddDescending(nums);
        System.out.println("Sorted output: " + Arrays.toString(result)); //Menampilkan hasil

        scanner.close(); //Tutup inputan

    }
}