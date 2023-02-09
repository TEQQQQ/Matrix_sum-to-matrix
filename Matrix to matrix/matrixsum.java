
import java.util.Scanner;

public class PrintCirclePattern {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("matrixin satir sayisi:");
		int satir = read.nextInt();

		System.out.println("matrixin sutun sayisi:");
		int sutun = read.nextInt();

		int matris[][] = new int[satir][sutun];

		// bak şimdi burada yeni matrisin satır sutununa +1 deme sebebimiz toplamlarının
		// geleceği kısım
		// zaten öncesini anlamışsındır diye umuyorum
		int yeni_matris[][] = new int[satir + 1][sutun + 1];

		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				System.out.println("matrisin bir sonraki elamanini giriniz: :");
				matris[i][j] = read.nextInt();

			}
		}
		// 20 ile 26. satırlar arası normal ana matrisin elemanlarının girilmesini
		// istiyoruz

		for (int a = 0; a < satir + 1; a++) {
			for (int b = 0; b < sutun + 1; b++) {
				// şimdi bak burası çokomelli burada bir yandan matrisi yeni matrise kopyalarken
				// bir yandan da kontrol
				// gerçekleştiriyorum normalda o satir sutun yazan yerlerde rakam var dı ama bu
				// sefer otomatik olmuyordu
				// diye bende rakamları optimize ettim o yüzden sana karışık gelebilir ama
				// özetle şöyle çalışıyor
				// şimdi ilk matris
				// 1 2 3
				// 4 5 6
				// 7 8 9
				// şeklinde ya hani yeni matriste de bunların toplamı olacak ya o yüzden yeni
				// matrisin son satir ve son
				// sutunlarında extra işlem uygulanıyor o işlemde iki if bloğu içinde kalan for
				// döngüsü
				// şimdi bu allttaki sadece son sutundaki sayiları buluyor yani 1+2+3 = 6 ,
				// 4+5+6 = 15, 7+8+9 = 24

				if (b == sutun) {
					if (a <= satir - 1) {
						// bak bu for işlemi son sutundan önce kaç tane eleman olduğunu bize buluyor
						// yani şimdi bu 3x3 bir
						// matris ama bu matris 2x4 de olabilirdi işte bu durumda da çalışsın diye for
						// döngüsü ile
						// o sutun numarasına kadar gelen elemanları yeni_matrisin son elemanına
						// toplayarak ekliyoruz
						// ve sonuç dediğim gibi 6 15 24 oluyor .
						for (int t = 0; t < sutun; t++) {
							yeni_matris[a][b] += matris[a][t];
						}

					}

					// bak bu alttaki de sadece satırlar için hani üstteki sutunlar içindi ya bu da
					// satırlar için bununda sonucu
					// 1 + 4 + 7 = 12 vs vs işte böyle gidiyor erindim gerisini yazmaya ve yine
					// içinde ki for da aynı şekilde
					// çalışıyor tek farkı bu sefer sutunları değilde satırlardaki sayıları buluyor

				}
				if (a == satir) {
					if (b <= sutun - 1) {
						for (int tt = 0; tt < satir; tt++) {
							yeni_matris[a][b] += matris[tt][b];
						}
					}

				}

				if (a <= satir - 1) {
					if (b <= sutun - 1) {
						// bu hemen alttaki kod matrisi yeni matrise kopyalıyor
						yeni_matris[a][b] = matris[a][b];
						// bu alttaki kod asıl önemli olan çünkü biz herşeyi yazdık iyi hoşta matrisin
						// en sağ alt köşedeki
						// elemanı nasıl bulacağız çünkü o yeni matrisin satır ve sutun toplamına eşit
						// bu durumda da şöyle bir şey gerçekleşiyor normal matrisin içindeki bütün
						// elemanların toplamının
						// 2 katı yeni matrisimizin son elemanı oluyor . Kafan yandıysa kendin elle
						// yapmayı dene anlarsın
						// orada biraz matematik konuşuyor o yüzden kafanın yanmış olması normal
						// örnek vermek gerekirse diyelim ki 2x2 şöyle bir matris var
						// 4 9
						// -3 7
						// şimdi bu matrisin bizim işlemleri yaptığımız zaman çıktısı şöyle oluyor
						// 4 9 13(4+9)
						// -3 7 4(-3+7)
						// 1(4-3) 16(9+7) ve son eleman belirsiz buradaki son elemanda işlemler
						// yapılınca 13+4+16+1 den 34 olmalı
						// dikkatli bakarsan zaten bizim ilk matirisn elemanları toplamı 17 oluyor bunun
						// da 2 katını o yüzden aldım
						// umarım anlamışsıdır
						yeni_matris[satir][sutun] += matris[a][b] * 2;
					}
				}

			}

		}
		// bu kısım işin süsleme kısmı sen daha rahat göresin gözlerin yorulmasın diye
		// yaptım
		System.out.println("sizin belirlediğiniz matris :");
		for (int ii = 0; ii < satir; ii++) {
			for (int jj = 0; jj < sutun; jj++) {

				System.out.print(matris[ii][jj] + " ");
			}
			System.out.println();
		}
		System.out.println("sonradan olusturulan matris :");
		for (int aa = 0; aa < satir + 1; aa++) {
			for (int bb = 0; bb < sutun + 1; bb++) {

				System.out.print(yeni_matris[aa][bb] + " ");
			}
			System.out.println();
		}
		// son olarak sen bunu 3x5 1x7 yada 4x4 gibi matrislerle dene daha iyi anlarsın
		// ve ayrıca , bilmen gereken kısım sadece
		// 20 ile 95. satırlar arası ki zaten yarısı yorum diğer kalan yarısının ,
		// yarısı ise matrisin elemanlarını yazdırmak
		// women bir de dönmüş diyorsun ki sEnİn hAFızAnI kÜçÜmSeMEKlE HaTa ETMemİSim
		// ...
		// KES GAHBE. HAFIZAMA HAKARET ETME, BÖYLE GÖT OLURSUN ...

	}
}