/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.dmn.engine.impl.cmd;

import java.io.Serializable;

import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.dmn.engine.impl.persistence.entity.DecisionTableEntity;
import org.flowable.dmn.engine.impl.util.CommandContextUtil;

/**
 * @author Tijs Rademakers
 */
public class GetDeploymentDecisionTableCmd implements Command<DecisionTableEntity>, Serializable {

    private static final long serialVersionUID = 1L;
    protected String decisionTableId;

    public GetDeploymentDecisionTableCmd(String decisionTableId) {
        this.decisionTableId = decisionTableId;
    }

    @Override
    public DecisionTableEntity execute(CommandContext commandContext) {
        return CommandContextUtil.getDmnEngineConfiguration().getDeploymentManager().findDeployedDecisionById(decisionTableId);
    }
}
