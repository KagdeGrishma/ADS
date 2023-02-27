package HospitalUsecase;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue_ {
    private static ArrayList<Patient> queue;

    public PriorityQueue_() {
        queue = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getQueue(){
        return queue;
    }

    public void addPatient(Patient patient) {
        queue.add(patient);
        Collections.sort(queue);
    }

    public Patient treatPatient() {
        return queue.remove(0);
    }

    public int getTotalTreatmentTime() {
        int totalTime = 0;
        for (Patient patient : queue) {
            totalTime += patient.getTreatmentTime();
        }
        return totalTime;
    }

    public int getPatientCount() {
        return queue.size();
    }

    public void updatePatientPriority(String name, int newUrgencyLevel) {
        for (Patient patient : queue) {
            if (patient.getName().equals(name)) {
                patient.setUrgencyLevel(newUrgencyLevel);
                break;
            }
        }
        Collections.sort(queue);
    }
}
