# BreedHorse

~~~ 
Let the horses/pigs breed better offspring under the effect of potion? 
~~~


It actually comes from a strange mechanism (possibly a bug?)
in the Bedrock edition where if you use speed potions on two horses and then breed them,
their offspring will be even faster.
By doing this repeatedly, you can stack the effect infinitely...

This plugin does not achieve that, it's just a crude imitation.
Of course, you can set a limit to prevent your players from breeding a horse so fast it crashes your server.

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

```

Don't set the speed too high, or the horses/pigs may start to trigger anti-cheat measures, although they may have already affected it.

### Permission
- breedhorse.command.reload [default: OP]
- breedhorse.command.version [default: OP]
- breedhorse.update_message [default: OP]

### Command
- /breedhorse:bhc <reload|version> [/bhc]

# Support
- Spigot
- Paper
- Folia
- and more.....

# License
It is `CC0 1.0 Universal`, nothing to say.