package com.acrypto.graphics;

public class IntroMessage {

    public static void printIntroMessage() {
        /*Print application banner*/
        Banner banner = new Banner();
        banner.printBanner();

        /*Print welcome message*/
        System.out.println(PrintingColors.YELLOW + "Welcome to CryptoMaker!\n");

        /*Print options*/
        final String optionsMessage =
                PrintingColors.PURPLE + "Please, select the encryption option you need: \n" +
                        PrintingColors.PURPLE + "(a) for " + PrintingColors.PURPLE_BOLD + "Encrypting/Decrypting Data; \n" +
                        PrintingColors.PURPLE + "(b) for " + PrintingColors.PURPLE_BOLD + "Generating Symmetric Key; \n" +
                        PrintingColors.PURPLE + "(c) for " + PrintingColors.PURPLE_BOLD + "Generating Asymmetric Keys; \n" +
                        PrintingColors.PURPLE + "(d) for " + PrintingColors.PURPLE_BOLD + "Generating Keystore; \n" +
                        PrintingColors.PURPLE + "(e) for " + PrintingColors.PURPLE_BOLD + "Generating Message Digest; \n" +
                        PrintingColors.PURPLE + "(f) for " + PrintingColors.PURPLE_BOLD + "Generating Message Authentication Code (MAC); \n" +
                        PrintingColors.PURPLE + "(g) for " + PrintingColors.PURPLE_BOLD + "Generating Digital Signature. \n";

        System.out.println(optionsMessage + PrintingColors.RESET);
    }
}
