# Git Hooks

This directory contains Git hooks for the project.

## Pre-commit Hook

The pre-commit hook automatically runs Spotless to format code before each commit.

### What it does:

1. Checks if any Java or Gradle files are staged for commit
2. Runs `./gradlew spotlessApply` to format the code
3. Re-stages any files that were formatted
4. Allows the commit to proceed

### Installation

The hook is automatically installed in `.git/hooks/pre-commit`. If you need to reinstall it:

```bash
cp .githooks/pre-commit .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

### Bypassing the hook

If you need to bypass the hook for a specific commit (not recommended):

```bash
git commit --no-verify
```

### Manual setup for team members

Team members should run:

```bash
cp .githooks/pre-commit .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

Or use the setup script:

```bash
./setup-git-hooks.sh
```

