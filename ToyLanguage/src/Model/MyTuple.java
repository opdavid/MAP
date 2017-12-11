package Model;

import java.io.BufferedReader;

public class MyTuple {
    private String filename;
    private BufferedReader fileDescriptor;

    public MyTuple(String filename, BufferedReader fileDescriptor) {
        this.filename = filename;
        this.fileDescriptor = fileDescriptor;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BufferedReader getFileDescriptor() {
        return fileDescriptor;
    }

    public void setFileDescriptor(BufferedReader fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }

    @Override
    public String toString() {
        return filename;
    }
}
