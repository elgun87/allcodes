package GurhanTask.Day9;

import Utilities.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLogin {
    LibraryLinkVer user;
    @Test
    public void test1() throws InterruptedException {
        LibraryLinkVer user = new LibraryLinkVer();
        user.logInToLibrary("student11@library", "tScBPCUr");
        Thread.sleep(2000);
        user.close();
    }

    @Test
    public void test2() throws InterruptedException {
        user = new LibraryLinkVer();
        user.logInToLibrary("student12@library", "UC0LC9Hj");
        Thread.sleep(2000);
        user.close();
    }
    @Test
    public void test3() throws InterruptedException {
        user = new LibraryLinkVer();
        user.logInToLibrary("student13@library", "zcVbvUWH");
        Thread.sleep(2000);
        user.close();
    }
    @Test
    public void test4() throws InterruptedException {
        user = new LibraryLinkVer();
        user.logInToLibrary("librarian13@library", "9rf6axdD");
        Thread.sleep(2000);
        user.close();
    }
}
