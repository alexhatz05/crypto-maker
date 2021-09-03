package com.acrypto.cryptomaker;

import com.acrypto.encryption.CryptoCipher;
import com.acrypto.graphics.PrintingColors;
import org.apache.commons.codec.binary.Hex;
import java.util.Scanner;

public class UserOptions {
    private static final String INVALID_CHOICE_MESSAGE = "You have entered an invalid choice!";

    static Scanner inScan = new Scanner(System.in);

    UserOptions() {
    }

    static void readUserOptions() {
        String userOption = inScan.nextLine();

        switch (userOption) {
            case "a":
                System.out.println(PrintingColors.YELLOW + "\nYou have selected Data Encryption/Decryption feature.");
                readEncDecOptions();
                break;
            case "b":
                System.out.println(PrintingColors.YELLOW + "You have selected Symmetric Key Generation.");
                break;
            case "c":
                System.out.println(PrintingColors.YELLOW + "You have selected Key Pair (Asymmetric Keys) Generation.");
                break;
            case "d":
                System.out.println(PrintingColors.YELLOW + "You have selected Keystore Generation.");
                break;
            case "e":
                System.out.println(PrintingColors.YELLOW + "You have selected Message Digest Generation.");
                break;
            case "f":
                System.out.println(PrintingColors.YELLOW + "You have selected Message Authentication Code (MAC) Generation.");
                break;
            case "g":
                System.out.println(PrintingColors.YELLOW + "You have selected Digital Signature Generation.");
                break;
            default:
                System.out.println(PrintingColors.RED + INVALID_CHOICE_MESSAGE);
                break;
        }

        inScan.close();
    }

    private static void readEncDecOptions() {
        /*Select Encryption or Decryption*/
        System.out.println(PrintingColors.PURPLE + "Please, select (e) for Encryption or (d) for Decryption mode.");
        String cipherEDMode = inScan.nextLine();

        /*Validate Input*/
        if (!cipherEDMode.equals("e") && !cipherEDMode.equals("d")) {
            System.out.println(PrintingColors.RED + INVALID_CHOICE_MESSAGE);
            System.exit(0);
        }

        /*Select Encryption Algorithm*/
        System.out.println(PrintingColors.PURPLE + "Please, now introduce the cipher: AES.");
        String cipher = inScan.nextLine();

        /*Validate Input*/
        if (!cipher.equals("AES")) {
            System.out.println(PrintingColors.RED + INVALID_CHOICE_MESSAGE);
            System.exit(0);
        }

        /*Select Encryption Mode*/
        System.out.println(PrintingColors.PURPLE + "Please, now select the cipher mode: ECB, CBC, CFB, OFB, CTR.");
        String cipherMode = inScan.nextLine();

        /*Validate Input*/
        if (!cipherMode.equals("ECB") && !cipherMode.equals("CBC") && !cipherMode.equals("CFB") && !cipherMode.equals("OFB")
                && !cipherMode.equals("CTR")) {
            System.out.println(PrintingColors.RED + INVALID_CHOICE_MESSAGE);
            System.exit(0);
        }

        /*Insert plaintext or ciphertext*/
        String text;
        if (cipherEDMode.equals("e")) {
            System.out.println("Please, provide the plain text to encrypt.");
            text = inScan.nextLine();
            CryptoCipher cryptoCipher = new CryptoCipher(cipher, cipherEDMode, cipherMode, text);
            System.out.println(
                    PrintingColors.BLUE + "The encrypted text is: " + Hex.encodeHexString(cryptoCipher.executeCipher()) + PrintingColors.RESET);
        }
        else {
            System.out.println("Please, provide the cipher text to decrypt.");
            text = inScan.nextLine();
            System.out.println("Please, provide the decryption key.");
            String key = inScan.nextLine();
            CryptoCipher cryptoCipher = new CryptoCipher(cipher, cipherEDMode, cipherMode, text, key);
            System.out.println(
                    PrintingColors.BLUE + "The decrypted text is: " + cryptoCipher.executeCipher() + PrintingColors.RESET);
        }
    }
}
