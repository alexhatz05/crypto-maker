package com.acrypto.graphics;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banner {
    private static final Logger logger = Logger.getLogger(Banner.class.getName());

    public void printBanner() {
        System.out.println(PrintingColors.CYAN+readBanner()+PrintingColors.RESET);
    }

    private String readBanner() {
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            File file = new File(Objects.requireNonNull(classLoader.getResource("banner.txt")).getFile());
            return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception occurred", ex);
            return "Banner not found";
        }
    }
}
