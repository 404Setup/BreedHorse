# BreedHorse

![Love under the cherry trees...and speed potion](https://media.forgecdn.net/attachments/1134/129/2025-03-22-201835-png.png)

It actually comes from a strange [bug](https://bugs.mojang.com/browse/MCPE-81890).

In Bedrock Edition, if you use a speed (or jump) potion on two rideable animals, then breed them, their offspring will have higher stats. By doing this repeatedly, you can stack the effect infinitely...

This mod/plugin does not implement this, it's just a crude imitation. Of course, you can set a limit to prevent players from breeding animals with too high stats.

# Config
```yaml
pig:
  enabled: true
  move:
    random:
      min: 0.03
      max: 0.06
    max: 0.3375
horse:
  enabled: true
  move:
    random:
      min: 0.03
      max: 0.06
    max: 0.3375
  jump:
    random:
      min: 0.04
      max: 0.11
    max: 1.0
donkey:
  enabled: true
  move:
    random:
      min: 0.03
      max: 0.06
    max: 0.3375
  jump:
    random:
      min: 0.04
      max: 0.11
    max: 1.0
mule:
  enabled: true
  move:
    random:
      min: 0.03
      max: 0.06
    max: 0.3375
  jump:
    random:
      min: 0.04
      max: 0.11
    max: 1.0
other:
  mixed-properties: false
```

Don't set the speed too high, or the horses/pigs may start to trigger anti-cheat measures, although they may have already affected it.

### Permission (only plugin)
- breedhorse.command.reload [default: OP]
- breedhorse.command.version [default: OP]
- breedhorse.update_message [default: OP]

### Command
- /bhc reload
- /bhc gui (only mod client | Forge is not supported yet)
- /bhc version (only plugin)

# Support
- Fabric
- Forge
- Spigot
- Paper
- Folia
- and more.....

# Not supported
- NeoForge (The template is damaged)
- Quilt (Low priority)

# License
## Plugin
```
This project is released into the public domain under the CC0 1.0 Universal license.

To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights to this software to the public domain worldwide. This software is distributed without any warranty.

You should have received a copy of the CC0 Public Domain Dedication along with this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
```

## Mod
```
© All Rights Reserved

## License Terms

1. Decompilation is only permitted for learning purposes. Any other form of decompilation is strictly prohibited.

2. Direct distribution of mod builds is not allowed without explicit authorization. All downloads must link back to the original project page.

3. Distribution in modpacks is prohibited, with the exception of modpacks using CurseForge or Modrinth format that do not contain the mod build itself and properly link to the project URL.

4. Any direct or indirect commercial use of this mod is strictly prohibited.

5. Removal or modification of the original author's name and this license declaration is forbidden.

This software is provided "as is", without warranty of any kind. The author reserves all rights not explicitly granted above.
```