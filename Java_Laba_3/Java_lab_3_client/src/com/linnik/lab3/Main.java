package com.linnik.lab3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_YELLOW = "\u001B[33m";

        public static void main(String[] args) throws IOException {
            List<Integer> value = null;

            if (args.length == 0) {
                System.out.println("No parameters was sent!");
                return;
            }

            try {
                value = new ArrayList<Integer>();
                try (FileInputStream inputStream = new FileInputStream(args[0])) {
                    int readResult;
                    do {
                        readResult = inputStream.read();
                        if (readResult != -1) {
                            value.add(readResult);
                        }

                    } while (readResult != -1);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File is not found!");
                return;
            } catch (IOException ex) {
                System.out.println("File error!");
                return;
            }

            DSP DSP = new DSP();
            DecimalFormat df = new DecimalFormat("###.###");

            System.out.println(ANSI_YELLOW + "\n.:|Physical characteristics of the digital signal|:." + ANSI_RESET);
            System.out.println("Dynamic signal range: " + ANSI_YELLOW + df.format(DSP.DynamicSignalRange(value))+ ANSI_RESET);
            System.out.println("Signal energy: " + ANSI_YELLOW + df.format(DSP.SignalEnergy(value))+ ANSI_RESET);
            System.out.println("Average signal power: " + ANSI_YELLOW + df.format(DSP.AverageSignalPower(value))+ ANSI_RESET);
            System.out.println("Average value signal readings: " + ANSI_YELLOW + df.format(DSP.AverageValueSignalReadings(value))+ ANSI_RESET);
            System.out.println("Variance signal readings: " + ANSI_YELLOW + df.format(DSP.VarianceSignalReadings(value))+ ANSI_RESET);
            for(int tau = 5; tau <= 15; tau++)
            {
                System.out.println("Autocorrelation discrete signal(" + tau + "): " + ANSI_YELLOW + df.format(DSP.AutocorrelationDiscreteSignal(value,tau))+ ANSI_RESET);
            }
            System.out.println("Correlation interval: " + ANSI_YELLOW + df.format(DSP.CorrelationInterval(value))+ ANSI_RESET);
        }
}
