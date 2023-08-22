-- 学生表
CREATE TABLE Student (
    sno VARCHAR(20) PRIMARY KEY,
    sname VARCHAR(50) NOT NULL
);

-- 课程表
CREATE TABLE Course (
    cno VARCHAR(20) PRIMARY KEY,
    cname VARCHAR(100) NOT NULL,
    credit DECIMAL(3, 1) NOT NULL
);

-- 选课表
CREATE TABLE Elective (
    sno VARCHAR(20),
    cno VARCHAR(20),
    PRIMARY KEY (sno, cno),
    FOREIGN KEY (sno) REFERENCES Student(sno),
    FOREIGN KEY (cno) REFERENCES Course(cno)
);

-- 成绩表
CREATE TABLE Grade (
    sno VARCHAR(20),
    cno VARCHAR(20),
    score DECIMAL(4, 1) NOT NULL,
    gpa DECIMAL(3, 1) GENERATED ALWAYS AS ((score / 10) - 5) STORED,
    PRIMARY KEY (sno, cno),
    FOREIGN KEY (sno, cno) REFERENCES Elective(sno, cno)
);
