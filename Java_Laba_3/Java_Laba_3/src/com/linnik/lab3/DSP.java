package com.linnik.lab3;

import java.util.Collections;
import java.util.List;

public class DSP {

    public int DynamicSignalRange(List<Integer> value) {
        int max = Collections.max(value);
        int min = Collections.min(value);

        return max - min;
    }

    public int SignalEnergy(List<Integer> value) {
        int output = 0;

        for (Integer i : value)
            output += (i * i);

        return output;
    }

    public double AverageSignalPower(List<Integer> value) {
        double output = 0;

        for (Integer i : value) {
            output += (i * i);
        }

        return output / value.size();
    }

    public double AverageValueSignalReadings(List<Integer> value) {
        double output = 0;

        for (Integer i : value) {
            output += i;
        }

        return output / value.size();
    }

    public double VarianceSignalReadings(List<Integer> value) {
        double m = AverageValueSignalReadings(value);
        double output = 0;

        for (Integer i : value) {
            output += ((i - m) * (i - m));
        }

        return output / value.size();
    }

    public double AutocorrelationDiscreteSignal(List<Integer> value, int tau) {
        double m = AverageValueSignalReadings(value);
        double output = 0;

        tau = (tau > 0) ? tau : -tau;

        for (int i = 0; i < value.size() - tau; i++) {
            output += (value.get(i + tau) - m) * (value.get(i) - m);
        }

        return output / (value.size() - tau);
    }

    public double CorrelationInterval(List<Integer> value) {
        double output = 0;

        for (int i = 0; i < value.size(); i++) {
            output += AutocorrelationDiscreteSignal(value, i);
        }

        return output / AutocorrelationDiscreteSignal(value, 0);
    }
}
