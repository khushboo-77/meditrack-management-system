import com.khush.meditrack.constants.Constants;
import com.khush.meditrack.entity.*;
import com.khush.meditrack.factory.BillFactory;
import com.khush.meditrack.observer.ConsoleNotificationObserver;
import com.khush.meditrack.service.*;
import com.khush.meditrack.util.AIHelper;
import com.khush.meditrack.util.AppConfig;
import com.khush.meditrack.util.CSVUtil;
import com.khush.meditrack.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        IdGenerator idGen = IdGenerator.getInstance();
        BillingService billingService = new BillingService();
        patientService.getAll().addAll(
                CSVUtil.loadPatients(Constants.DATA_FOLDER + "patients.csv")
        );

        AppConfig config = AppConfig.getInstance();
        System.out.println(
                config.getAppName() + " v" + config.getVersion()
        );

        appointmentService.addObserver(
                new ConsoleNotificationObserver()
        );


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
            -------- MediTrack --------
            1. Add Doctor
            2. View Doctors
            3. Add Patient
            4. View Patients
            5. Create Appointment
            6. View Appointments
            7. Cancel Appointment
            8. GENERATING A BILL for an appointment
            9. Save Data and Exit
            """);

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    Specialization spec = AIHelper.suggestSpecialization("heart pain");
                    Doctor d = new Doctor(
                            idGen.nextId(),
                            "Dr Demo",
                            40,
                            "9999999999",
                            spec,
                            500
                    );
                    doctorService.addDoctor(d);
                    System.out.println("Doctor added");
                }

                case 2 -> doctorService.getAllDoctors()
                        .forEach(d -> System.out.println(d.getName()));

                case 3 -> {
                    Patient p = new Patient(
                            idGen.nextId(),
                            "Patient Demo",
                            30,
                            "8888888888",
                            "Cold"
                    );
                    patientService.addPatient(p);
                    System.out.println("Patient added");
                }

                case 4 -> patientService.getAll()
                        .forEach(p -> System.out.println(p.getName()));

                case 5 -> {
                    if (doctorService.getAllDoctors().isEmpty()
                            || patientService.getAll().isEmpty()) {
                        System.out.println("Add doctor and patient first");
                        break;
                    }

                    Appointment a = new Appointment(
                            idGen.nextId(),
                            doctorService.getAllDoctors().get(0),
                            patientService.getAll().get(0),
                            LocalDateTime.now()
                    );
                    appointmentService.create(a);
                    System.out.println("Appointment created");
                }

                case 6 -> appointmentService.getAll()
                        .forEach(System.out::println);

                case 7 -> {
                    System.out.print("Enter appointment id to cancel: ");
                    int id = sc.nextInt();
                    appointmentService.cancelById(id);
                    System.out.print("Successfully cancelled the appointment");
                }

                case 8 -> {
                    if (appointmentService.getAll().isEmpty()) {
                        System.out.println("No appointments found");
                        break;
                    }

                    Appointment a = appointmentService.getAll().get(0);
                    // Bill bill = new Bill(a.getDoctor().getConsultationFee());
                    Bill bill = BillFactory.createBill(
                            a.getDoctor().getConsultationFee()
                    );
                    BillSummary summary = billingService.generateSummary(bill);

                    System.out.println("Total Bill Amount: " + summary.getTotalAmount());
                }

                case 9 -> {
                    CSVUtil.savePatients(
                            patientService.getAll(),
                            Constants.DATA_FOLDER + "patients.csv"
                    );
                    System.out.println("Data saved. Exiting...");
                    return;
                }
            }
        }
    }
}
