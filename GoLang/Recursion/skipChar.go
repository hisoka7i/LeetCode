package main

func skipChar(str string) string {
	if len(str) == 0 {
		return ""
	}
	if str[0] == 'a' {
		return skipChar(str[1:])
	}
	return string(str[0]) + skipChar(str[1:])
}
