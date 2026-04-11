-- 코드를 작성해주세요
SELECT fi.ID, fni.FISH_NAME, fift.LENGTH
FROM FISH_INFO fi
    JOIN (
        SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
        FROM FISH_INFO
        GROUP BY FISH_TYPE
    ) fift 
        ON fi.FISH_TYPE = fift.FISH_TYPE AND fi.LENGTH = fift.LENGTH
    JOIN FISH_NAME_INFO fni
        ON fift.FISH_TYPE = fni.FISH_TYPE
ORDER BY fi.ID