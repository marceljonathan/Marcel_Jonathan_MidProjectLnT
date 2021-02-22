import java.util.Scanner;
import java.util.Vector;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
//		Karyawan dataKaryawan = new Karyawan("XX-781", "Jojon", "Laki-laki", "Admin", 4000000);
//		System.out.println(dataKaryawan.getKode());
//		System.out.println(dataKaryawan.getNama());
//		System.out.println(dataKaryawan.getJenisKelamin());
//		System.out.println(dataKaryawan.getJabatan());
//		System.out.println(dataKaryawan.getGaji());
//		
//		Karyawan dataKaryawan2 = new Karyawan("BK-891", "Joni", "Laki-laki", "Supervisor", 6000000);
//		System.out.println(dataKaryawan2.getKode());
//		System.out.println(dataKaryawan2.getNama());
//		System.out.println(dataKaryawan2.getJenisKelamin());
//		System.out.println(dataKaryawan2.getJabatan());
//		System.out.println(dataKaryawan2.getGaji());
		Menu();
	}
	
	Scanner scan = new Scanner(System.in);
	Vector<Karyawan> daftarKaryawan = new Vector<Karyawan>();
	Vector<KaryawanClone> daftarKaryawan2 = new Vector<KaryawanClone>();
	
	void Clear() {
		for(int i = 0; i < 5; i++) {
			System.out.println("");
		}
	}
	
	
	
	int adminCount = 0, managerCount = 0, supervisorCount = 0, moduloAdmin = 3, moduloManager = 3, moduloSupervisor = 3;
	
	void Menu() {
		int choose;
		
		do {
			Clear();
			System.out.println("Selamat Datang di Sistem Data Karyawan PT. Mentol");
			System.out.println("--------------------------------------------------\n");
			System.out.println("Silahkan memilih salah satu menu berikut ini:");
			System.out.println("1. Input Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			System.out.print("Menu yang dipilih: ");
			choose = scan.nextInt();
			scan.nextLine();
		}while(choose < 1 || choose > 5);
		
		switch(choose) {
		case 1:
			InsertData();
			break;
		case 2:
			ViewData();
			break;
		case 3:
			UpdateData();
			break;
		case 4:
			DeleteData();
			break;
		case 5:
			Clear();
			break;
		}
	}
	
	void InsertData() {
		String kodeKaryawan, namaKaryawan, jenisKelaminKaryawan, jabatanKaryawan;
		int gajiKaryawan = 0;
		
		Clear();
		
		System.out.println("Input Data Karyawan");
		System.out.println("---------------------\n");
		
		String numeric = "0123456789";
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String join = "-";
		
		StringBuilder sb1 = new StringBuilder(2);
		StringBuilder sb2 = new StringBuilder(4);
		
		for (int i = 0; i < 2; i++) { 
			int index = (int)(alphabets.length() * Math.random()); 
			sb1.append(alphabets.charAt(index)); 
		} 
		
		for (int i = 0; i < 4; i++) { 
			int index = (int)(numeric.length() * Math.random()); 
			sb2.append(numeric.charAt(index)); 
		}
		
		String kode = sb1.toString();
		String angka = sb2.toString();
		
		kode = kode.concat(join);
		kode = kode.concat(angka);
		
		kodeKaryawan = kode;
		
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			namaKaryawan = scan.nextLine();
		}while(namaKaryawan.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenisKelaminKaryawan = scan.nextLine();
		}while(!(jenisKelaminKaryawan.contentEquals("Laki-laki") || jenisKelaminKaryawan.contentEquals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatanKaryawan = scan.nextLine();
		}while(!(jabatanKaryawan.contentEquals("Manager") || jabatanKaryawan.contentEquals("Supervisor") || jabatanKaryawan.contentEquals("Admin")));
		
		if(jabatanKaryawan.contentEquals("Manager")) {
			do {
				System.out.print("Input gaji: ");
				gajiKaryawan = scan.nextInt();
				scan.nextLine();
			}while(gajiKaryawan != 8000000);
			managerCount++;
		}else if(jabatanKaryawan.contentEquals("Supervisor")) {
			do {
				System.out.print("Input gaji: ");
				gajiKaryawan = scan.nextInt();
				scan.nextLine();
			}while(gajiKaryawan != 6000000);
			supervisorCount++;
		}else if(jabatanKaryawan.contentEquals("Admin")) {
			do {
				System.out.print("Input gaji: ");
				gajiKaryawan = scan.nextInt();
				scan.nextLine();
			}while(gajiKaryawan != 4000000);
			adminCount++;
		}
		
		daftarKaryawan.add(new Karyawan(kodeKaryawan, namaKaryawan, jenisKelaminKaryawan, jabatanKaryawan, gajiKaryawan));
		daftarKaryawan2.add(new KaryawanClone(kodeKaryawan, namaKaryawan, jenisKelaminKaryawan, jabatanKaryawan, gajiKaryawan));
	
		System.out.println("\nBerhasil menambahkan karyawan dengan id " + kodeKaryawan);
		
		if((managerCount - 1) % moduloManager == 0 && managerCount != 1) {
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < (daftarKaryawan.size()) - 1; i++) {
				if(daftarKaryawan.get(i).getJabatan().contentEquals("Manager")) {
					System.out.print(" " + daftarKaryawan.get(i).getKode());
					int gajiBaru = daftarKaryawan.get(i).getGaji() + ((daftarKaryawan.get(i).getGaji() * 10)/100);
					daftarKaryawan.get(i).setGaji(gajiBaru);
					for(int j = 0; j < daftarKaryawan2.size(); j++) {
						if(daftarKaryawan2.get(j).getKodeClone().contentEquals(daftarKaryawan.get(i).getKode())) {
							daftarKaryawan2.get(j).setGajiClone(gajiBaru);
						}
					}
				}
			}
			moduloManager += 3;
		}
		
		if((supervisorCount - 1) % moduloSupervisor == 0 && supervisorCount != 1) {
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < (daftarKaryawan.size()) - 1; i++) {
				if(daftarKaryawan.get(i).getJabatan().contentEquals("Supervisor")) {
					System.out.print(" " + daftarKaryawan.get(i).getKode());
					int gajiBaru = daftarKaryawan.get(i).getGaji() + ((daftarKaryawan.get(i).getGaji() * 75)/1000);
					daftarKaryawan.get(i).setGaji(gajiBaru);
					for(int j = 0; j < daftarKaryawan2.size(); j++) {
						if(daftarKaryawan2.get(j).getKodeClone().contentEquals(daftarKaryawan.get(i).getKode())) {
							daftarKaryawan2.get(j).setGajiClone(gajiBaru);
						}
					}
				}
			}
			moduloSupervisor += 3;
		}
		
		if((adminCount - 1) % moduloAdmin == 0 && adminCount != 1) {
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < (daftarKaryawan.size()) - 1; i++) {
				if(daftarKaryawan.get(i).getJabatan().contentEquals("Admin")) {
					System.out.print(" " + daftarKaryawan.get(i).getKode());
					int gajiBaru = daftarKaryawan.get(i).getGaji() + ((daftarKaryawan.get(i).getGaji() * 5)/100);
					daftarKaryawan.get(i).setGaji(gajiBaru);
					for(int j = 0; j < daftarKaryawan2.size(); j++) {
						if(daftarKaryawan2.get(j).getKodeClone().contentEquals(daftarKaryawan.get(i).getKode())) {
							daftarKaryawan2.get(j).setGajiClone(gajiBaru);
						}
					}
				}
			}
			moduloAdmin += 3;
		}
		
		daftarKaryawan2.sort(new Sorting());
		
//		System.out.println("Manager Count: " + managerCount);
//		System.out.println("Supervisor Count: " + supervisorCount);
//		System.out.println("Admin Count: " + adminCount);
		
		System.out.println("\nENTER to return");
		scan.nextLine();
		Menu();
		
	}
	
	void ViewData() {
		Clear();
		
		if(daftarKaryawan.isEmpty()) {
			System.out.println("There is no data");
			System.out.println("ENTER to return");
			scan.nextLine();
			Menu();
		}else {
			
//			for(int i = 0; i < daftarKaryawan2.size()-1; i++) {
//				for(int j = 0; j < i-daftarKaryawan2.size()-1; j++) {
//					String kalimat1 = daftarKaryawan2.get(j).getNamaClone();
//					String kalimat2 = daftarKaryawan2.get(j+1).getNamaClone();
//					if(daftarKaryawan2.get(j).getNamaClone().compareToIgnoreCase(daftarKaryawan2.get(j+1).getNamaClone())) {
//						String temp1 = daftarKaryawan2.get(j).getKodeClone();
//						daftarKaryawan2.get(j).setKodeClone(daftarKaryawan2.get(j+1).getKodeClone());
//						daftarKaryawan2.get(j+1).setKodeClone(temp1);
//						
//						String temp2 = daftarKaryawan2.get(j).getNamaClone();
//						daftarKaryawan2.get(j).setNamaClone(daftarKaryawan2.get(j+1).getNamaClone());
//						daftarKaryawan2.get(j+1).setNamaClone(temp2);
//						
//						String temp3 = daftarKaryawan2.get(j).getJenisKelaminClone();
//						daftarKaryawan2.get(j).setJenisKelaminClone(daftarKaryawan2.get(j+1).getJenisKelaminClone());
//						daftarKaryawan2.get(j+1).setJenisKelaminClone(temp3);
//						
//						String temp4 = daftarKaryawan2.get(j).getJabatanClone();
//						daftarKaryawan2.get(j).setJabatanClone(daftarKaryawan2.get(j+1).getJabatanClone());
//						daftarKaryawan2.get(j+1).setJabatanClone(temp4);
//						
//						int temp5 = daftarKaryawan2.get(j).getGajiClone();
//						daftarKaryawan2.get(j).setGajiClone(daftarKaryawan2.get(j+1).getGajiClone());
//						daftarKaryawan2.get(j+1).setGajiClone(temp5);
//					}
//				}
//			}
			
//			for(int i = 0; i < daftarKaryawan.size(); i++) {
//				System.out.println(daftarKaryawan.get(i).getKode() + " - " + daftarKaryawan.get(i).getNama() + " - " + daftarKaryawan.get(i).getJenisKelamin() + " - " + daftarKaryawan.get(i).getJabatan() + " - " + daftarKaryawan.get(i).getGaji());
//			}
			
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			System.out.printf("| No |  Kode Karyawan  |         Nama Karyawan        | Jenis Kelamin |    Jabatan    |Gaji Karyawan|\n");
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			
			for(int i = 0; i < daftarKaryawan2.size(); i++) {
				System.out.printf("|%4d|%17s|%30s|%15s|%15s|%13d|\n", i+1, daftarKaryawan2.get(i).getKodeClone(), daftarKaryawan2.get(i).getNamaClone(), daftarKaryawan2.get(i).getJenisKelaminClone(), daftarKaryawan2.get(i).getJabatanClone(), daftarKaryawan2.get(i).getGajiClone());
				System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			}
			System.out.println("\nENTER to return");
			scan.nextLine();
			Menu();
		}
	}
	
	void UpdateData() {
		int dataUpdate, gajiUpdated = 0;
		String kodeBaru, namaBaru, jabatanBaru, jenisKelaminBaru;
		
		if(daftarKaryawan.isEmpty()) {
			System.out.println("There is no data");
			System.out.println("ENTER to return");
			scan.nextLine();
			Menu();
		}else {
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			System.out.printf("| No |  Kode Karyawan  |         Nama Karyawan        | Jenis Kelamin |    Jabatan    |Gaji Karyawan|\n");
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			
			for(int i = 0; i < daftarKaryawan2.size(); i++) {
				System.out.printf("|%4d|%17s|%30s|%15s|%15s|%13d|\n", i+1, daftarKaryawan2.get(i).getKodeClone(), daftarKaryawan2.get(i).getNamaClone(), daftarKaryawan2.get(i).getJenisKelaminClone(), daftarKaryawan2.get(i).getJabatanClone(), daftarKaryawan2.get(i).getGajiClone());
				System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			}
			
			do {
				System.out.print("\nSelect Number to Update (0 to exit)(1-" + daftarKaryawan2.size() + "): ");
				dataUpdate = scan.nextInt();
				scan.nextLine();
			}while(dataUpdate < 0 || dataUpdate > daftarKaryawan2.size());
			
			if(dataUpdate == 0) {
				System.out.println("ENTER to return");
				scan.nextLine();
				Menu();
			}else {
				System.out.print("Input kode baru: ");
				kodeBaru = scan.nextLine();
				
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getKode().equals(daftarKaryawan2.get(dataUpdate-1).getKodeClone())) {
						daftarKaryawan.get(i).setKode(kodeBaru);
					}
				}
				
				daftarKaryawan2.get(dataUpdate-1).setKodeClone(kodeBaru);
				
				do {
					System.out.print("Input nama karyawan [>= 3]: ");
					namaBaru = scan.nextLine();
				}while(namaBaru.length() < 3);
				
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getNama().equals(daftarKaryawan2.get(dataUpdate-1).getNamaClone())) {
						daftarKaryawan.get(i).setNama(namaBaru);
					}
				}
				
				daftarKaryawan2.get(dataUpdate-1).setNamaClone(namaBaru);
				
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					jenisKelaminBaru = scan.nextLine();
				}while(!(jenisKelaminBaru.contentEquals("Laki-laki") || jenisKelaminBaru.contentEquals("Perempuan")));
				
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getJenisKelamin().equals(daftarKaryawan2.get(dataUpdate-1).getJenisKelaminClone())) {
						daftarKaryawan.get(i).setJenisKelamin(jenisKelaminBaru);
					}
				}
				
				daftarKaryawan2.get(dataUpdate-1).setJenisKelaminClone(jenisKelaminBaru);
				
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					jabatanBaru = scan.nextLine();
				}while(!(jabatanBaru.contentEquals("Manager") || jabatanBaru.contentEquals("Supervisor") || jabatanBaru.contentEquals("Admin")));
				
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getJabatan().equals(daftarKaryawan2.get(dataUpdate-1).getJabatanClone())) {
						daftarKaryawan.get(i).setJabatan(jabatanBaru);
					}
				}
				
				if(daftarKaryawan2.get(dataUpdate-1).getJabatanClone().contentEquals("Admin")) {
					adminCount--;
				}
				
				if(daftarKaryawan2.get(dataUpdate-1).getJabatanClone().contentEquals("Manager")) {
					managerCount--;
				}
				
				if(daftarKaryawan2.get(dataUpdate-1).getJabatanClone().contentEquals("Supervisor")) {
					supervisorCount--;
				}
				
				daftarKaryawan2.get(dataUpdate-1).setJabatanClone(jabatanBaru);
				
				if(jabatanBaru.contentEquals("Manager")) {
					do {
						System.out.print("Input gaji: ");
						gajiUpdated = scan.nextInt();
						scan.nextLine();
					}while(gajiUpdated != 8000000);
					managerCount++;
				}else if(jabatanBaru.contentEquals("Supervisor")) {
					do {
						System.out.print("Input gaji: ");
						gajiUpdated = scan.nextInt();
						scan.nextLine();
					}while(gajiUpdated != 6000000);
					supervisorCount++;
				}else if(jabatanBaru.contentEquals("Admin")) {
					do {
						System.out.print("Input gaji: ");
						gajiUpdated = scan.nextInt();
						scan.nextLine();
					}while(gajiUpdated != 4000000);
					adminCount++;
				}
				
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getGaji() == daftarKaryawan2.get(dataUpdate-1).getGajiClone()) {
						daftarKaryawan.get(i).setGaji(gajiUpdated);
					}
				}
				
				daftarKaryawan2.get(dataUpdate-1).setGajiClone(gajiUpdated);
				
				daftarKaryawan2.sort(new Sorting());
				
				System.out.println("\nData Berhasil Diperbaharui");
				System.out.println("\nENTER to return");
				scan.nextLine();
				Menu();
			}
		}
	}
	
	void DeleteData() {
		int hapusData;
		
		if(daftarKaryawan.isEmpty()) {
			System.out.println("There is no data");
			System.out.println("ENTER to return");
			scan.nextLine();
			Menu();
		}else {
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			System.out.printf("| No |  Kode Karyawan  |         Nama Karyawan        | Jenis Kelamin |    Jabatan    |Gaji Karyawan|\n");
			System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			
			for(int i = 0; i < daftarKaryawan2.size(); i++) {
				System.out.printf("|%4d|%17s|%30s|%15s|%15s|%13d|\n", i+1, daftarKaryawan2.get(i).getKodeClone(), daftarKaryawan2.get(i).getNamaClone(), daftarKaryawan2.get(i).getJenisKelaminClone(), daftarKaryawan2.get(i).getJabatanClone(), daftarKaryawan2.get(i).getGajiClone());
				System.out.printf("|----|-----------------|------------------------------|---------------|---------------|-------------|\n");
			}
			
			do {
				System.out.print("\nSelect Number to Update (0 to exit)(1-" + daftarKaryawan2.size() + "): ");
				hapusData = scan.nextInt();
				scan.nextLine();
			}while(hapusData < 0 || hapusData > daftarKaryawan2.size());
			
			if(hapusData == 0) {
				System.out.println("ENTER to return");
				scan.nextLine();
				Menu();
			}else {
				for(int i = 0; i < daftarKaryawan.size(); i++) {
					if(daftarKaryawan.get(i).getKode().equals(daftarKaryawan2.get(hapusData-1).getKodeClone())) {
						daftarKaryawan.remove(i);
					}
				}
				
				if(daftarKaryawan2.get(hapusData-1).getJabatanClone().contentEquals("Admin")) {
					adminCount--;
				}
				
				if(daftarKaryawan2.get(hapusData-1).getJabatanClone().contentEquals("Supervisor")) {
					supervisorCount--;
				}
				
				if(daftarKaryawan2.get(hapusData-1).getJabatanClone().contentEquals("Manager")) {
					managerCount--;
				}
				
				daftarKaryawan2.remove(hapusData-1);
				
				daftarKaryawan2.sort(new Sorting());
				
				System.out.println("\nData Berhasil Dihapus");
				System.out.println("\nENTER to return");
				scan.nextLine();
				Menu();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
