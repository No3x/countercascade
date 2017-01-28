# countercascade  [![Build Status](https://travis-ci.org/No3x/countercascade.svg?branch=master)](https://travis-ci.org/No3x/countercascade) [![codecov](https://codecov.io/gh/No3x/countercascade/branch/master/graph/badge.svg)](https://codecov.io/gh/No3x/countercascade)
This is a example about using counter to build something useful like a clock. 
Inspired by [cprogramming.com](http://www.cprogramming.com/tips/tip/increment-and-decrement-counters-with-rollover)

![untitled2.svg](https://rawgit.com/No3x/countercascade/master/assets/countersClassDiagram.svg)
# Counter
The counter stores a value that can be `incremented` and `decremented` in a multithread safe way realized with an `AtomicInteger`.

# Modcounter
A modcounter is s modulo `n` counter. Example `n = 3`

|  x  |  x % n  |
|:---:|:-------:|
|  1  |    1    |
|  2  |    2    |
|  3  |    0    |
|  4  |    1    |
|  5  |    2    |
|  6  |    0    |
|  7  |    1    |
|  8  |    2    |
See the pattern? It's `1-2-0-1-2-0`.

Let's transfer this to the time. A minute consists of 60s - after the 59th second the counter starts from 0 again. 
So obviously this is the same as `f(t) = t % 60`.
The visualization shows the seconds, minutes and hours over 61 minutes in seconds.

![untitled.svg](https://rawgit.com/No3x/countercascade/master/assets/counters.svg)
After 60s a minute passed. So it's the same principle for the minutes. After 60 minutes a hour passed. After 24 hours a day passed.
So we have some kind of carry for each unit if it resets to 0. We need to carry the next bigger unit.

# LinkedModCounter
A linked modulo counter is capable to handle this carry. It knows his next bigger unit. Putting multiple counters in a row we can call this a cascade.
