# RevertBrainChange

In Minecraft 1.19 there's a change to `net.minecraft.entity.ai.Brain#tickMemories` to now expire memories before processing them, this is the opposite behaviour to previous versions.

This change makes sense in terms of code flow, but seems to have had some unexpected effects, like reducing Iron Golem spawn rate by 100 ticks per spawn attempt.

More information can be found in [MC-254100](https://bugs.mojang.com/browse/MC-254100)