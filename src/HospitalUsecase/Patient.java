package HospitalUsecase;

public class Patient implements Comparable<Patient> {
    private String name;
    private int urgencyLevel;
    private int treatmentTime;
    private int doctorId;

    public Patient(String name, int urgencyLevel, int treatmentTime, int doctorId) {
        this.name = name;
        this.urgencyLevel = urgencyLevel;
        this.treatmentTime = treatmentTime;
        this.doctorId = doctorId;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public int getTreatmentTime() {
        return treatmentTime;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Patient otherPatient) {
        if (this.urgencyLevel != otherPatient.urgencyLevel) {
            return Integer.compare(otherPatient.urgencyLevel, this.urgencyLevel);
        } else {
            return Integer.compare(this.doctorId, otherPatient.doctorId);
        }
    }
}
