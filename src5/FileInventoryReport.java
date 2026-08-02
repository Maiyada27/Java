public class FileInventoryReport {

    public static void main(String[] args) {

        String[] files = {"photo.png,340", "app.java,8", "report.pdf,120", "music.mp3,5000", "notes.txt,50", "script.py,25", "wrongRecord"};

        int totalSize = 0;
        int totalFiles = 0;
        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;
        String largestFile = "";
        int largestSize = 0;

        for (String record : files) {    /*loop through the files and split the name and size by the comma*/
            String[] parts = record.split(",");

            if (parts.length != 2) {   /*check if the file is entered correctly, if not skip it.*/
                System.out.println("Skipping malformed record: " + record);
                continue;
            }

            String fileName = parts[0].trim();
            int size = Integer.parseInt(parts[1].trim());  /*convert the size from string to integer*/


            String extension = "";

            int dotPosition = fileName.lastIndexOf(".");
            if (dotPosition != -1) {
                extension = fileName.substring(dotPosition + 1).toLowerCase();  /*get the extension*/
            }

            String classification = "";

            if (extension.equals("txt") || extension.equals("pdf")
                    || extension.equals("docx") || extension.equals("xlsx")) {

                classification = "Document";
                documentCount++;

            } else if (extension.equals("jpg") || extension.equals("png")
                    || extension.equals("gif")) {

                classification = "Image";
                imageCount++;

            } else if (extension.equals("mp3") || extension.equals("wav")) {

                classification = "Audio";
                audioCount++;

            } else if (extension.equals("java") || extension.equals("py")
                    || extension.equals("js")) {

                classification = "Code";
                codeCount++;

            } else {

                classification = "Other";
                otherCount++;
            }
            System.out.printf("File: %-15s Extension: %-5s Type: %-10s Size: %d KB%n", fileName, extension, classification, size);
        }
        System.out.println("--- Summary ---");
        System.out.println("Total files: " + totalFiles);
        System.out.println("Total size: " + totalSize + " KB");

        System.out.println("Document: " + documentCount);
        System.out.println("Image: " + imageCount);
        System.out.println("Audio: " + audioCount);
        System.out.println("Code: " + codeCount);
        System.out.println("Other: " + otherCount);

        System.out.println("Largest file: " + largestFile +
                " (" + largestSize + " KB)");
    }
}
