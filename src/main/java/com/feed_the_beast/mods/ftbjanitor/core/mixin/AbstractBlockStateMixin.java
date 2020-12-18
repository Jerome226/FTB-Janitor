package com.feed_the_beast.mods.ftbjanitor.core.mixin;

import com.feed_the_beast.mods.ftbjanitor.FTBJanitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author LatvianModder
 */
@Mixin(targets = "net.minecraft.block.AbstractBlock$AbstractBlockState")
public class AbstractBlockStateMixin
{
	@Inject(method = "cacheState", at = @At("HEAD"), cancellable = true)
	public void cacheState(CallbackInfo ci)
	{
		if (FTBJanitorConfig.disableBlockStateCache)
		{
			ci.cancel();
		}
	}
}
