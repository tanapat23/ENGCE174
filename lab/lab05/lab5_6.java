package lab5;

class Media {
    protected String title;

    public Media(String title) {
        this.title = title; // Set media title
    }

    public void process() {
        // Default message
        System.out.println("Starting generic media processing.");
    }
}

class Video extends Media {
    protected int duration;

    public Video(String title, int duration) {
        super(title); // Call parent constructor
        this.duration = duration;
    }

    @Override
    public void process() {
        // Custom message for video
        System.out.println("Processing video: " + title + " for " + duration + " minutes.");
    }
}

class Audio extends Media {
    protected String quality;

    public Audio(String title, String quality) {
        super(title); // Call parent constructor
        this.quality = quality;
    }

    @Override
    public void process() {
        // Custom message for audio
        System.out.println("Processing audio: " + title + " with " + quality + " quality.");
    }
}

class Processor {
    public static void runProcessor(Media m) {
        // Polymorphic call
        m.process();
    }
}

public class MediaProcess {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ------------------- VIDEO INPUT -------------------
        System.out.print("Enter video title: ");
        String vTitle = sc.nextLine();

        System.out.print("Enter video duration (minutes): ");
        int duration;

        // Validation #1: numeric check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid duration. Setting to 0.");
            duration = 0;
            sc.nextLine();
        } else {
            duration = sc.nextInt();
            sc.nextLine(); // Clear buffer
        }

        // Validation #2: non-negative
        if (duration < 0) {
            System.out.println("Negative duration not allowed. Setting to 0.");
            duration = 0;
        }

        // ------------------- AUDIO INPUT -------------------
        System.out.print("Enter audio title: ");
        String aTitle = sc.nextLine();

        System.out.print("Enter audio quality: ");
        String quality = sc.nextLine();

        // Validation #1: empty string check
        if (quality.trim().isEmpty()) {
            System.out.println("Invalid quality. Setting to 'Unknown'.");
            quality = "Unknown";
        }

        // Validation #2: minimal length check
        if (quality.length() < 3) {
            System.out.println("Quality too short. Setting to 'Unknown'.");
            quality = "Unknown";
        }

        // ------------------- OBJECT CREATION -------------------
        Video video = new Video(vTitle, duration);
        Audio audio = new Audio(aTitle, quality);

        // ------------------- PROCESSING -------------------
        Processor.runProcessor(video);
        Processor.runProcessor(audio);

        sc.close();
    }
}
