import Jama.Matrix;

interface ActivationFunction {
    double run(double i);
    
}
public class NeuralNetwork{
    ActivationFunction function;
    double full[][][];
    int inputNodes;
    int hiddenNodes;
    int outputNodes;
    Matrix weights_ih, weights_ho, bias_h, bias_o;
    public NeuralNetwork(int inputs, int hidden, int output, ActivationFunction function){
        this.function = function;
        full = new double[4][][];
        inputNodes = inputs;
        hiddenNodes = hidden;
        outputNodes = output;
        weights_ih = Matrix.random(hiddenNodes, inputNodes);
        weights_ho = Matrix.random(outputNodes, hiddenNodes);
        bias_h =  Matrix.random(hiddenNodes, 1);
        bias_o =  Matrix.random(outputNodes, 1);
        full[0] = weights_ho.getArray();
        full[1] = weights_ih.getArray();
        full[2] = bias_h.getArray();
        full[3] = bias_o.getArray();
    }
    public double[] feedforward(double[] inputs){
        double[][] in = new double[inputs.length][1];
        for (int i = 0; i < in.length; i++) {
            in[i][0] = inputs[i];
        }
        // Matrix wih = weights_ih.copy();
        Matrix hidden = weights_ih.times(Matrix.constructWithCopy(in));
        hidden.plusEquals(bias_h);
        map(hidden);
       
        Matrix output = weights_ho.times(hidden);
        output.plusEquals(bias_o);
        map(output);
        double[] out = new double[output.getRowDimension()];
        for (int i = 0; i < out.length; i++) {
            out[i] = output.getArray()[i][0];
        }
        return out;
    }
    public void map(Matrix matrix){
        double[][] array = matrix.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = function.run(array[i][j]);
            }
        }
    }
    public static NeuralNetwork crossover(double mutation, NeuralNetwork a,NeuralNetwork b){
        NeuralNetwork child = new NeuralNetwork(a.inputNodes, a.hiddenNodes, a.outputNodes, a.function);
        for (int i = 0; i < child.full.length; i++) {
            for (int j = 0; j < child.full[i].length; j++) {
                for (int j2 = 0; j2 < child.full[i][j].length; j2++) {
                    if(j2%2==1) child.full[i][j][j2] = a.full[i][j][j2];
                    else child.full[i][j][j2] = b.full[i][j][j2];
                    if (Math.random()< mutation) child.full[i][j][j2] += Math.random()*3 - 1.5;
                }
            }
        }
        return child;

    }
}