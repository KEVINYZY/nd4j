package org.nd4j.linalg.api.ops.impl.layers.convolution;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.impl.layers.convolution.config.Conv3DConfig;

import java.util.List;


/**
 * Conv3DDerivative operation
 */
@Slf4j
public class Conv3DDerivative extends Conv3D {

    public Conv3DDerivative() {}

    @Builder(builderMethodName = "derivativeBuilder")
    public Conv3DDerivative(SameDiff sameDiff, DifferentialFunction[] inputFunctions, INDArray[] inputs, INDArray[] outputs, Conv3DConfig conv3DConfig) {
        super(sameDiff, inputFunctions, inputs, outputs, conv3DConfig);
    }

    @Override
    public String opName() {
        return "conv3d_bp";
    }


    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> f1) {
        throw new UnsupportedOperationException("Unable to differentiate from a derivative op");
    }

}