recursion = do
    putStrLn (show (looplikefactorial 2))


--2018-11-08 recursion function 1 with sub function & acc var(res)
looplikefactorial :: Int -> Int
looplikefactorial n = go n 1
    where 
    go n res
        | n > 1     = go (n - 1) (n * res)
        | otherwise = res

--2018-11-08 recursion function 2
normalfactorial :: Int -> Int
normalfactorial 0 = 1
noramlfactorial n = n * normalfactorial (n - 1)


--2018-11-08 recursion function 3 (replicate 2 'a' = "aa")
_replicate :: Int -> a -> [a]
_replicate 1 x = x : []
_replicate n x = _replicate (n - 1) x ++ (x : [])

