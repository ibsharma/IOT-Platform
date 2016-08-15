package com.example.rules;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ishaan
 */
@Service
public class RulesService {

    private static RulesEngine rulesEngine;

    @Autowired
    Overweight overweight;

    @Autowired
    Underweight underweight;

    public RulesEngine getRulesEngine() {
        if(rulesEngine != null) {
            RulesEngineBuilder ruleEngineBuilder = RulesEngineBuilder.aNewRulesEngine();
            rulesEngine = ruleEngineBuilder.build();
        }
        return rulesEngine;
    }

    public void executeRules(Double baseWeight, double currentWeight)
    {
        RulesEngineBuilder ruleEngineBuilder = RulesEngineBuilder.aNewRulesEngine();
        rulesEngine = ruleEngineBuilder.build();
        rulesEngine.clearRules();

        overweight.setBaseWeight(baseWeight);
        overweight.setCurrentWeight(currentWeight);

        underweight.setBaseWeight(baseWeight);
        underweight.setCurrentWeight(currentWeight);

        rulesEngine.registerRule(overweight);
        rulesEngine.registerRule(underweight);

        rulesEngine.fireRules();
    }

}
