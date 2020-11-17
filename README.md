# JDA - Example

## Table of Contents

<ol>
    <li><a href="#about-this-repository">About this Repository</a></li>
    <li><a href="#single-instance-vs-sharded-instance">Single Instances vs. Sharded Instances</a></li>
</ol>

## About this Repository

This Repository is made to provide an easy example of the coding using the JDA.

<br>

## Single Instance vs. Sharded Instance

<br>

| Single Instance                          | Sharded Instance                       |
|------------------------------------------|----------------------------------------|
| - Used for Bots with a small guild count | - Used for Bots with a big guild count |
| - One Websocket Connection               | - Multiple Websocket Connection        |

<br>

### Sharded Instance

Sharded Bots create multiple Websocket Connections to split the amount of events, one Websocket has to handle. The Single Instance Bot, however just uses one Websocket as it doesn't need to handle many events.
<br>It is recommended to use 1 Shard per 450 Guilds. You can calculate the Shard ID of a Guild with the following formula: 

`shard_id = (guild_id >> 22) % num_shards`

You should always just use the amount of Shards that you need as every Shard creates its own Websocket Connection. That means that every shards needs resources that you/your server needs to have.
<br><br>

### Single Instance

*FOLLOWING*
<br>
We have divided the two possibilities into two packages.
<br>`de.th3ph4nt0m.jdaexample.single` wraps all classes of a single instance bot
<br>`de.th3ph4nt0m.jdaexample.sharded` wraps all classes of a sharded bot
