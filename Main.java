import java.util.ArrayList;

class Session {
    private String nameLocation;
    private String dateTopic;
    private int numParticipants;

    public Session(String nameLocation, String dateTopic, int numParticipants) {
        this.nameLocation = nameLocation;
        this.dateTopic = dateTopic;
        this.numParticipants = numParticipants;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getDateTopic() {
        return dateTopic;
    }

    public void setDateTopic(String dateTopic) {
        this.dateTopic = dateTopic;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }
}

class Conference {

    private ArrayList<Session> sessions = new ArrayList<>();

    public Conference() {
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public double calculateAverageParticipants() {
        if (sessions.size() == 0) return 0.0;
        int totalParticipants = 0;
        for (Session session : sessions) {
            totalParticipants += session.getNumParticipants();
        }
        return (double) totalParticipants / sessions.size();
    }

    public Session findMaxParticipantsSession() {
        if (sessions.size() == 0) return null;
        Session maxSession = sessions.get(0);
        for (Session session : sessions) {
            if (session.getNumParticipants() > maxSession.getNumParticipants()) {
                maxSession = session;
            }
        }
        return maxSession;
    }
}

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();

        conference.addSession(new Session("Kyiv, Conference Hall A", "2024-04-10, AI Developments", 120));
        conference.addSession(new Session("Lviv, Conference Hall B", "2024-04-12, Future of Robotics", 150));
        conference.addSession(new Session("Odessa, Conference Hall C", "2024-04-14, Quantum Computing", 90));

        double averageParticipants = conference.calculateAverageParticipants();
        System.out.println("Average number of participants: " + averageParticipants);

        Session maxSession = conference.findMaxParticipantsSession();
        System.out.println("Session with the maximum number of participants: " +
                maxSession.getNameLocation() + " - " +
                maxSession.getDateTopic() + " - " +
                maxSession.getNumParticipants() + " participants");
    }
}
