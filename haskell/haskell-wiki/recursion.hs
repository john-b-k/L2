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

--takeInt 3 [1..5] == [1, 2, 3]
takeInt :: Int -> [a] -> [a]
takeInt n (x:xs) 
    | n > 1     = x : (takeInt (n - 1) xs)
    | otherwise = x : []



-- [[1,2,3], [12,13], [90]]   -> [1,12,90]
map :: (a -> b) -> [a] -> [b]
head :: [a] -> a

(map head) :: [[a]] -> [a]
map head xs:xss 
map _ [] = []
map head xs:xss = (head xs) : map head xss


-- _last [1,5,7,8] == 8
_last :: [a] -> a
_last (x:xs) 
    | length xs == 0 = x    
    | otherwise      = _last ((head xs) : (tail xs))

-- _init [1..4] == [1,2,3]
_init :: [a] -> [a]
_init (x:xs)
    | length xs >=  1 = x : _init xs 
    | otherwise     = []
