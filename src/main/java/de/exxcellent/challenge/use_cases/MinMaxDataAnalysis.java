package de.exxcellent.challenge.use_cases;

import java.util.zip.DataFormatException;

class MinMaxDataAnalysis {
    String filename;
    String fileType;

    MinMaxDataAnalysis() {}

    MinMaxDataAnalysis(String filename) throws DataFormatException {
        int extensionIndex = filename.lastIndexOf('.');
        if (extensionIndex == -1) {
            this.filename = filename;
            this.fileType = "csv";
        }
        else if (extensionIndex < filename.length() - 1)
        {
            this.filename = filename.substring(0, extensionIndex);
            this.fileType = filename.substring(extensionIndex + 1);
        }
        else {
            throw new DataFormatException();
        }
    }

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }
}
