package HospitalUsecase;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PriorityQueue_ queue = new PriorityQueue_();
        Scanner sc = new Scanner(System.in);
        int numDoctors = 3;
        int[] doctorAvailability = new int[numDoctors];
        int nextAvailableDoctor = 0;

        System.out.println("Enter the number of patients to be treated: ");
        int numPatients = sc.nextInt();

        for (int i = 0; i < numPatients; i++) {
            System.out.println("Enter patient name: ");
            String name = sc.next();
            System.out.println("Enter patient urgency level: ");
            int urgencyLevel = sc.nextInt();
            System.out.println("Enter patient treatment time: ");
            int treatmentTime = sc.nextInt();

            // assign a doctor to the patient
            int doctorId = nextAvailableDoctor;
            doctorAvailability[doctorId] += treatmentTime;
            nextAvailableDoctor = (nextAvailableDoctor + 1) % numDoctors;

            Patient patient = new Patient(name, urgencyLevel, treatmentTime, doctorId);
            queue.addPatient(patient);
        }

        System.out.println("Treatment order: ");
        for (Patient patient : queue.getQueue()) {
            System.out.println(patient.getName());
        }

        System.out.println("Total treatment time: " + queue.getTotalTreatmentTime());

        System.out.println("Enter a patient name to update their priority: ");
        String name = sc.next();
        System.out.println("Enter the new urgency level: ");
        int newUrgencyLevel = sc.nextInt();

        queue.updatePatientPriority(name, newUrgencyLevel);
        System.out.println("Treatment of patient " + name + " is updated!");

        System.out.println("Updated treatment order: ");
        for (Patient patient : queue.getQueue()) {
            System.out.println(patient.getName());
        }

        System.out.println("Total treatment time: " + queue.getTotalTreatmentTime());
    }
}
