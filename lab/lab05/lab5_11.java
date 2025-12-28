package lab5;

class Document {
    protected String title;

    public Document(String title) {
        this.title = title; // Store title
    }

    public void displayDetails() {
        System.out.println("Document: " + title); // Default detail display
    }
}

class TextDocument extends Document {
    protected int wordCount;

    public TextDocument(String title, int wordCount) {
        super(title); // Call parent constructor
        this.wordCount = wordCount; // Store word count
    }

    @Override
    public void displayDetails() {
        // Display text document details
        System.out.println("Text: " + title + ", Words: " + wordCount);
    }
}

class PDFDocument extends Document {
    protected int pageCount;

    public PDFDocument(String title, int pageCount) {
        super(title); // Call parent constructor
        this.pageCount = pageCount; // Store page count
    }

    @Override
    public void displayDetails() {
        // Display PDF document details
        System.out.println("PDF: " + title + ", Pages: " + pageCount);
    }
}

public class DocumentCount {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ---------------- INPUT SET 1 : TEXT DOCUMENT ----------------
        System.out.print("Enter text doc 1 title: ");
        String t1Title = sc.nextLine();

        System.out.print("Enter text doc 1 word count: ");
        int t1Words = readPositiveInt(sc);

        // ---------------- INPUT SET 1 : PDF DOCUMENT -----------------
        sc.nextLine(); // clear buffer
        System.out.print("Enter PDF doc 1 title: ");
        String p1Title = sc.nextLine();

        System.out.print("Enter PDF doc 1 page count: ");
        int p1Pages = readPositiveInt(sc);

        // ---------------- INPUT SET 2 : TEXT DOCUMENT ----------------
        sc.nextLine();
        System.out.print("Enter text doc 2 title: ");
        String t2Title = sc.nextLine();

        System.out.print("Enter text doc 2 word count: ");
        int t2Words = readPositiveInt(sc);

        // ---------------- INPUT SET 2 : PDF DOCUMENT -----------------
        sc.nextLine();
        System.out.print("Enter PDF doc 2 title: ");
        String p2Title = sc.nextLine();

        System.out.print("Enter PDF doc 2 page count: ");
        int p2Pages = readPositiveInt(sc);

        // ---------------- OBJECT CREATION ----------------
        TextDocument t1 = new TextDocument(t1Title, t1Words);
        PDFDocument p1 = new PDFDocument(p1Title, p1Pages);
        TextDocument t2 = new TextDocument(t2Title, t2Words);
        PDFDocument p2 = new PDFDocument(p2Title, p2Pages);

        Document[] docs = { t1, p1, t2, p2 };

        // ---------------- COUNT PDF PAGES ----------------
        int totalPages = 0;
        for (Document d : docs) {
            if (d instanceof PDFDocument) { // Check type
                PDFDocument pdf = (PDFDocument) d; // Downcast
                totalPages += pdf.pageCount; // Add pages
            }
        }

        // ---------------- DISPLAY DETAILS ----------------
        for (Document d : docs) {
            d.displayDetails();
        }

        // ---------------- DISPLAY TOTAL ----------------
        System.out.println("Total Pages: " + totalPages);

        sc.close();
    }

    // ======= HELPER METHOD: VALIDATED INTEGER INPUT =======
    private static int readPositiveInt(java.util.Scanner sc) {
        int value;

        // Validation #1: check numeric
        if (!sc.hasNextInt()) {
            System.out.println("Invalid number. Setting to 0.");
            sc.next(); // consume invalid input
            return 0;
        }

        value = sc.nextInt();

        // Validation #2: non-negative
        if (value < 0) {
            System.out.println("Negative value not allowed. Setting to 0.");
            return 0;
        }

        return value;
    }
}
