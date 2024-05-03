package net.axtro.willsplayground.client.sound;

import net.axtro.willsplayground.WillsPlayground;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WPSoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WillsPlayground.MOD_ID);


    public static final RegistryObject<SoundEvent> RAW_ENZORITE_BLOCK_BREAK = registerSoundEvents("raw_enzorite_block_break");
    public static final RegistryObject<SoundEvent> RAW_ENZORITE_BLOCK_PLACE = registerSoundEvents("raw_enzorite_block_place");
    public static final RegistryObject<SoundEvent> RAW_ENZORITE_BLOCK_HIT = registerSoundEvents("raw_enzorite_block_hit");
    public static final RegistryObject<SoundEvent> RAW_ENZORITE_BLOCK_STEP = registerSoundEvents("raw_enzorite_block_step");
    public static final RegistryObject<SoundEvent> RAW_ENZORITE_BLOCK_FALL = registerSoundEvents("raw_enzorite_block_fall");

    public static final ForgeSoundType RAW_ENZORITE_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            WPSoundRegistry.RAW_ENZORITE_BLOCK_BREAK, WPSoundRegistry.RAW_ENZORITE_BLOCK_PLACE,
            WPSoundRegistry.RAW_ENZORITE_BLOCK_HIT, WPSoundRegistry.RAW_ENZORITE_BLOCK_STEP, WPSoundRegistry.RAW_ENZORITE_BLOCK_FALL);


    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(WillsPlayground.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {SOUND_EVENTS.register(eventBus);}
}
