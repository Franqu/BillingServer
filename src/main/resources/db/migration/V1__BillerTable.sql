CREATE TABLE Bill (
id UUID NOT NULL PRIMARY KEY,
phoneNumberCaller VARCHAR(100) NOT NULL,
phoneNumberReceiver VARCHAR(100) NOT NULL,
ongoing BOOLEAN ,
lenght NUMERIC,
size NUMERIC,
callTime DATE,
connectionType int

)