/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.transforms;

import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformOp;

import java.util.List;

/**
 * Set range to a particular set of values
 *
 * @author Adam Gibson
 */
public class SetRange extends BaseTransformOp {

    private double min, max;

    public SetRange(SameDiff sameDiff, DifferentialFunction i_v, boolean inPlace, double min, double max) {
        super(sameDiff, i_v, inPlace);
        this.min = min;
        this.max = max;
    }

    public SetRange(SameDiff sameDiff, DifferentialFunction i_v, int[] shape, boolean inPlace, Object[] extraArgs, double min, double max) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
        this.min = min;
        this.max = max;
    }

    public SetRange(SameDiff sameDiff, DifferentialFunction i_v, Object[] extraArgs, double min, double max) {
        super(sameDiff, i_v, extraArgs);
        this.min = min;
        this.max = max;
    }

    public SetRange() {}

    public SetRange(INDArray x) {
        this(x, 0, 1);
    }

    public SetRange(INDArray x, INDArray z, double min, double max) {
        super(x, z);
        this.min = min;
        this.max = max;
        init(x, y, z, n);
    }

    public SetRange(INDArray x, INDArray z, long n, double min, double max) {
        super(x, z, n);
        this.min = min;
        this.max = max;
        init(x, y, z, n);
    }

    public SetRange(INDArray x, INDArray y, INDArray z, long n, double min, double max) {
        super(x, y, z, n);
        this.min = min;
        this.max = max;
        init(x, y, z, n);
    }

    public SetRange(INDArray x, double min, double max) {
        super(x);
        this.min = min;
        this.max = max;
        init(x, y, z, n);
    }

    @Override
    public int opNum() {
        return 9;
    }

    @Override
    public String opName() {
        return "setrange";
    }
    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }

    @Override
    public void init(INDArray x, INDArray y, INDArray z, long n) {
        super.init(x, y, z, n);
        this.extraArgs = new Object[] {min, max};
    }



    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> f1) {
        return null;
    }
}
