package com.hpspells.core.spell;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.inventivetalent.particle.ParticleEffect;

import com.hpspells.core.HPS;
import com.hpspells.core.SpellTargeter.SpellHitEvent;
import com.hpspells.core.spell.Spell.SpellInfo;

@SpellInfo(
        name = "Avada Kedavra",
        description = "descAvadaKedavra",
        range = 50,
        goThroughWalls = false,
        cooldown = 300
)
public class AvadaKedavra extends Spell {

    public AvadaKedavra(HPS instance) {
        super(instance);
    }

    public boolean cast(final Player p) {
        HPS.SpellTargeter.register(p, new SpellHitEvent() {
            @Override
            public void hitEntity(LivingEntity entity) {
                entity.setHealth(0);
            }

            @Override
            public void hitBlock(Block block) {
                HPS.PM.warn(p, HPS.Localisation.getTranslation("spellLivingEntityOnly"));

            }
        }, 1f, ParticleEffect.REDSTONE);
        return true;
    }

}
